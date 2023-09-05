package com.manieri.projetoaraucaria.ui.mainmenu.sideBarSelections;

public interface ModelSubMenu {


    int numberOfSubMenusOpen = 0;

    public void actionSubMenu(int relativeIndex);

    public void changeStatus();

}
