package com.web.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 
 */
public class Menu implements Serializable {
    private Integer menuID;

    private String menuName;

    private String menuUrl;

    private String menuImage;

    private Integer parentID;

    private Integer menuLevel;

    private Integer menuSort;

    private Integer isDelete;
    
    private List<Menu> childMenu= new ArrayList<>();

    private static final long serialVersionUID = 1L;

    public Integer getMenuID() {
        return menuID;
    }

    public void setMenuID(Integer menuID) {
        this.menuID = menuID;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuImage() {
        return menuImage;
    }

    public void setMenuImage(String menuImage) {
        this.menuImage = menuImage;
    }

    public Integer getParentID() {
        return parentID;
    }

    public void setParentID(Integer parentID) {
        this.parentID = parentID;
    }

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    public Integer getMenuSort() {
        return menuSort;
    }

    public void setMenuSort(Integer menuSort) {
        this.menuSort = menuSort;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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
        Menu other = (Menu) that;
        return (this.getMenuID() == null ? other.getMenuID() == null : this.getMenuID().equals(other.getMenuID()))
            && (this.getMenuName() == null ? other.getMenuName() == null : this.getMenuName().equals(other.getMenuName()))
            && (this.getMenuUrl() == null ? other.getMenuUrl() == null : this.getMenuUrl().equals(other.getMenuUrl()))
            && (this.getMenuImage() == null ? other.getMenuImage() == null : this.getMenuImage().equals(other.getMenuImage()))
            && (this.getParentID() == null ? other.getParentID() == null : this.getParentID().equals(other.getParentID()))
            && (this.getMenuLevel() == null ? other.getMenuLevel() == null : this.getMenuLevel().equals(other.getMenuLevel()))
            && (this.getMenuSort() == null ? other.getMenuSort() == null : this.getMenuSort().equals(other.getMenuSort()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMenuID() == null) ? 0 : getMenuID().hashCode());
        result = prime * result + ((getMenuName() == null) ? 0 : getMenuName().hashCode());
        result = prime * result + ((getMenuUrl() == null) ? 0 : getMenuUrl().hashCode());
        result = prime * result + ((getMenuImage() == null) ? 0 : getMenuImage().hashCode());
        result = prime * result + ((getParentID() == null) ? 0 : getParentID().hashCode());
        result = prime * result + ((getMenuLevel() == null) ? 0 : getMenuLevel().hashCode());
        result = prime * result + ((getMenuSort() == null) ? 0 : getMenuSort().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", menuID=").append(menuID);
        sb.append(", menuName=").append(menuName);
        sb.append(", menuUrl=").append(menuUrl);
        sb.append(", menuImage=").append(menuImage);
        sb.append(", parentID=").append(parentID);
        sb.append(", menuLevel=").append(menuLevel);
        sb.append(", menuSort=").append(menuSort);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

	public List<Menu> getChildMenu() {
		return childMenu;
	}

	public void setChildMenu(List<Menu> childMenu) {
		this.childMenu = childMenu;
	}
}