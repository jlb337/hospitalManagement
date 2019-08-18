package com.web.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class PositionMenuKey implements Serializable {
    private Integer menuID;

    private Integer poId;

    private static final long serialVersionUID = 1L;

    public Integer getMenuID() {
        return menuID;
    }

    public void setMenuID(Integer menuID) {
        this.menuID = menuID;
    }

    public Integer getPoId() {
        return poId;
    }

    public void setPoId(Integer poId) {
        this.poId = poId;
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
        PositionMenuKey other = (PositionMenuKey) that;
        return (this.getMenuID() == null ? other.getMenuID() == null : this.getMenuID().equals(other.getMenuID()))
            && (this.getPoId() == null ? other.getPoId() == null : this.getPoId().equals(other.getPoId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMenuID() == null) ? 0 : getMenuID().hashCode());
        result = prime * result + ((getPoId() == null) ? 0 : getPoId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", menuID=").append(menuID);
        sb.append(", poId=").append(poId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}