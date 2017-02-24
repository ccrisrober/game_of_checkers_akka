/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maldicion069.game_of_checkers.messages;

import java.io.Serializable;

/**
 *
 * @author maldicion069
 */
public class Point implements Serializable {

    protected int _x;
    protected int _y;

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }

    public Point(int x, int y) {
        this._x = x;
        this._y = y;
    }
}
