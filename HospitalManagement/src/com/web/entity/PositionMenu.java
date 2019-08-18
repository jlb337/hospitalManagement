package com.web.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class PositionMenu extends PositionMenuKey implements Serializable {
    private Integer positionMenuID;

    private static final long serialVersionUID = 1L;

    public Integer getPositionMenuID() {
        return positionMenuID;
    }

    public void setPositionMenuID(Integer positionMenuID) {
        this.positionMenuID = positionMenuID;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PositionMenu other = (PositionMenu) that;
        return (this.getMenuID() == null ? other.getMenuID() == null : this.getMenuID().equals(other.getMenuID()))
            && (this.getPoId() == null ? other.getPoId() == null : this.getPoId().equals(other.getPoId()))
            && (this.getPositionMenuID() == null ? other.getPositionMenuID() == null : this.getPositionMenuID().equals(other.getPositionMenuID()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMenuID() == null) ? 0 : getMenuID().hashCode());
        result = prime * result + ((getPoId() == null) ? 0 : getPoId().hashCode());
        result = prime * result + ((getPositionMenuID() == null) ? 0 : getPositionMenuID().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", positionMenuID=").append(positionMenuID);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}