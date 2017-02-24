/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maldicion069.game_of_checkers.actors;

import akka.actor.ActorRef;
import akka.persistence.UntypedPersistentActor;
import com.maldicion069.game_of_checkers.DrawChessBoardMessage;
import com.maldicion069.game_of_checkers.messages.MoveMessage;
import com.maldicion069.game_of_checkers.messages.Point;

/**
 *
 * @author maldicion069
 */
public class ChessGameActor extends UntypedPersistentActor {

    private ActorRef _renderActor;

    //@Override
    //public void onReceive(Object o) throws Throwable {
    private void handle(Object o) {
        if (o instanceof MoveMessage) {
            MoveMessage mm = (MoveMessage) o;
            System.out.println(mm);
            Point fromPoint = this.translateMove(mm.getFrom());
            Point toPoint = this.translateMove(mm.getTo());

            char piece = this.chessBoard[fromPoint.getY()][fromPoint.getX()];

            chessBoard[fromPoint.getY()][fromPoint.getX()] = ' '; // erase old location
            chessBoard[toPoint.getY()][toPoint.getX()] = piece; // set new location

            this.redrawBoard();
        }
    }

    private char[][] chessBoard = new char[][]{
        "rnbqkbnr".toCharArray(),
        "pppppppp".toCharArray(),
        "        ".toCharArray(),
        "        ".toCharArray(),
        "        ".toCharArray(),
        "        ".toCharArray(),
        "PPPPPPPP".toCharArray(),
        "RNBQKBNR".toCharArray()
    };

    public ChessGameActor(ActorRef renderActor) {
        this._renderActor = renderActor;

        this.redrawBoard();
    }

    private void redrawBoard() {
        DrawChessBoardMessage msg = new DrawChessBoardMessage(this.chessBoard);
        this._renderActor.tell(msg, this.getSelf());
    }

    private Point translateMove(String move) {
        char colChar = move.charAt(0);
        char rowChar = move.charAt(1);

        int col = colChar - 97;
        int row = 8 - (rowChar - '0');

        return new Point(col, row);
    }

    @Override
    public void onReceiveRecover(Object o) throws Exception {
        handle(o);
        Thread.sleep(2000);
    }

    @Override
    public void onReceiveCommand(Object o) throws Exception {
        persist(o, (Object evt) -> {
            System.out.println(evt);
        });
    }

    @Override
    public String persistenceId() {
        return "myid";
    }
}
