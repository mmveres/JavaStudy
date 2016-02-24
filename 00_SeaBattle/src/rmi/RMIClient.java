package rmi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.concurrent.TimeUnit;

import entities.User;
import entities.cells.CoordinateCell;
import entities.cells.ShotResult;
import logic.BattleField;
import logic.BattleFieldController;
import logic.ConsolePrinter;
import logic.EnemyFieldController;

public class RMIClient {
	private User user;
	private String url;
	private RMIGameServer gameServer;
	private BattleField myBattleField;
	private BattleField enemyBattleField;
	private BattleFieldController battleFieldController;
	private EnemyFieldController enemyFieldController;
	private volatile boolean stop;
	private long signage=-1;

	public RMIClient(User user) {
		this.user = user;
		url = "//localhost:" + Server.REGISTRY_PORT + "/" + Server.SERVER_NAME;
		try {
			gameServer = (RMIGameServer) Naming.lookup(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("RMI object found");

	}

	public void start() {
		myBattleField = new BattleField();
		enemyBattleField = new BattleField();
		battleFieldController = new BattleFieldController(myBattleField);
		battleFieldController.generateFleet(false);
		enemyFieldController = new EnemyFieldController(enemyBattleField);
		final ConsolePrinter cp = new ConsolePrinter(myBattleField, enemyBattleField);
		final BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		try {
			signage = gameServer.addUser(user);
			if (signage != -1) {
				new Thread(new Runnable() {

					@Override
					public void run() {
						System.out.println("User " + user);
						cp.printBattlefield();
						while (!stop) {
							try {
								if (gameServer.isAlive()) {
//									System.out.println("User " + user);
//									cp.printBattlefield();
									if (gameServer.whosTurn() == user.getIdUser()) {
										CoordinateCell incomingShot = gameServer.getShot(signage);
										CoordinateCell outgoingShot = null;
										ShotResult outgoingResult=null;
										//got result for previous shooting?
										ShotResult incomigResult = gameServer.getResult(signage);
										if (incomigResult != null) {
											//reflect it
											enemyFieldController.setShotResult(incomigResult);
										}
										//got incoming shot?
										if(incomingShot!=null){
											//process it (this will reflect on my field also)
											outgoingResult=battleFieldController.shootCell(incomingShot);
											//put result on server
											gameServer.putResult(outgoingResult, signage);
										}
										//if enemy missed
										if(incomingShot==null||!outgoingResult.isHit()){
											try {
												System.out.println("User " + user);
												cp.printBattlefield();
												System.out.println("Now move!");
												String temp=keyboard.readLine();
												if (temp.equals("stop")){
													stop=true;
													gameServer.stop(signage);
													break;
												}else{
													String []c=temp.split(",");
													int x=Integer.parseInt(c[0]);
													int y=Integer.parseInt(c[1]);
													outgoingShot = new CoordinateCell(x, y);
													enemyFieldController.setShot(outgoingShot);
												}
											} catch (IOException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										}
										
										
										

									} else {
										try {
//											System.out.println(""+ user + "wait for other...");
											TimeUnit.MILLISECONDS.sleep(200);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
								} else {
									stop = true;
								}
							} catch (RemoteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}

					}
				}).start();

			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
