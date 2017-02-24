/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maldicion069.game_of_checkers.actors;

import akka.actor.UntypedActor;
import com.maldicion069.game_of_checkers.DrawChessBoardMessage;
import static com.maldicion069.game_of_checkers.main.clearConsole;

/**
 *
 * @author maldicion069
 */
public class ChessBoardDrawingActor extends UntypedActor {

    @Override
    public void onReceive(Object o) throws Exception {
        if (o instanceof DrawChessBoardMessage) {
            clearConsole();
            char[][] chessBoard = ((DrawChessBoardMessage) o).getChessBoard();
            for (int i = 0; i < chessBoard.length; ++i) {
                char[] row = chessBoard[i];

                // Draw grid numbers
                System.out.print(String.format("{8 - %d", i));
                System.out.print(" ");

                // Draw row
                for (int j = 0; j < row.length; ++j) {
                    System.out.print(String.format("%s", row[j]));
                }
                System.out.println("");
            }
        }
    }
}
