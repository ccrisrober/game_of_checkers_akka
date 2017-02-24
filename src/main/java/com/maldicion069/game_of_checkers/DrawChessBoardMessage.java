/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maldicion069.game_of_checkers;

import java.io.Serializable;

/**
 *
 * @author maldicion069
 */
public class DrawChessBoardMessage implements Serializable {

    protected char[][] _chessBoard;

    public DrawChessBoardMessage(char[][] _chessBoard) {
        this._chessBoard = _chessBoard;
    }

    public char[][] getChessBoard() {
        return _chessBoard;
    }
}
