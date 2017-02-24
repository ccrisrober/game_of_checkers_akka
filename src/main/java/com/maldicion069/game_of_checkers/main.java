/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maldicion069.game_of_checkers;

import com.maldicion069.game_of_checkers.messages.MoveMessage;
import com.maldicion069.game_of_checkers.actors.ChessGameActor;
import com.maldicion069.game_of_checkers.actors.ChessBoardDrawingActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maldicion069
 */
public class main {
    static ActorSystem system;
    public static void main(String[] args) {
        try {
            system = ActorSystem.create("ChessSystem");
            final ActorRef drawActor = system.actorOf(
                    Props.create(ChessBoardDrawingActor.class), "DrawingActor");
            
            ActorRef gameActor = system.actorOf(
                    Props.create(ChessGameActor.class, drawActor), "GameActor");
            
           // HandleInput(gameActor);
            
            Thread.sleep(4000);
            gameActor.tell(new MoveMessage("f2", "f3"), ActorRef.noSender());
            //Thread.sleep(4000);
            gameActor.tell(new MoveMessage("e7", "e5"), ActorRef.noSender());
            //Thread.sleep(4000);
            gameActor.tell(new MoveMessage("g2", "g4"), ActorRef.noSender());
            //Thread.sleep(4000);
            gameActor.tell(new MoveMessage("d8", "h4"), ActorRef.noSender());
        } catch (InterruptedException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void HandleInput(ActorRef gameActor) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select new move: ");
        while (!scanner.nextLine().equals("quit"))
        {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");
            
            switch(tokens[0])
            {
                case "move":
                {
                    String from = tokens[1];
                    String to = tokens[3];
                    MoveMessage message = new MoveMessage(from, to);

                    gameActor.tell(message, ActorRef.noSender());
                }
            }
            System.out.println("Select new move: ");
        }
        //system.terminate();
    }
    
    public final static void clearConsole()
    {
        for (int i = 0; i < 5; ++i) System.out.println();
        /*try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }*/
    }
    }
