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
public class MoveMessage implements Serializable {

    protected String _from;
    protected String _to;

    public MoveMessage(String _from, String _to) {
        this._from = _from;
        this._to = _to;
    }

    public String getFrom() {
        return _from;
    }

    public String getTo() {
        return _to;
    }

    @Override
    public String toString() {
        return String.format("move %s to %s", _from, _to);
    }
}
