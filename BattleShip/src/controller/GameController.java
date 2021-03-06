/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.ShipCellList;
import util.ApplicationConstants;
import util.Position;
import util.SharedObject;
import view.PositionLabel;

/**
 *
 * @author truong
 */
public class GameController extends MouseAdapter{
    
    private SharedObject turn;
    private ShipCellList shipCellList;
    
    public GameController(SharedObject turn, ShipCellList shipCellList){
        this.turn = turn;
        this.shipCellList = shipCellList;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(turn.getCurrentTurn());
        PositionLabel lblFire = (PositionLabel) e.getSource();
        //if the current turn is human, let they go
        if(turn.getCurrentTurn().equals(ApplicationConstants.PLAYER_HUMAN)){
            Position firePosition = new Position(lblFire.getLblRow(), lblFire.getLblCol());
            shipCellList.humanFireComputer(firePosition);
        }
        lblFire.removeMouseListener(lblFire.getMouseListeners()[0]);
    }
    
}
