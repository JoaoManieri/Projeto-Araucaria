package com.manieri.projetosequoia.ui.mainmenu.sideBarSelections;

public interface ModelSubMenu {


    int numberOfSubMenusOpen = 0;

    public void actionSubMenu(int relativeIndex);

    public void changeStatus();

}
