package com.ruse.world.content.upgrade;

import com.ruse.world.World;
import com.ruse.world.entity.impl.player.Player;

public class upgradeable {


    public static enum UpgItem {
        STARTER_HELM(1153, new int[]{17415}, 75, 1157);

        private int[] reqItem;
        private int startItem;
        private int chance;
        private int EndItem;

        UpgItem(int startItem, int[] reqItem, int chance, int EndItem) {
            this.startItem = startItem;
            this.reqItem = reqItem;
            this.chance = chance;
            this.EndItem = EndItem;
        }

        public int getStartItem() {
            return this.startItem;//should work ye okay also the boolean?
        }

        public int[] getReqItem() {
            return this.reqItem;
        }

        public int getChance() {
            return this.chance;
        }

        public int getEndItem() {
            return this.EndItem;
        }

        public static boolean checkReq(Player p) { //test it and let me see
            for (UpgItem item : UpgItem.values()) {
                if (item.reqItem != null) {
                    for (int i = 0; i < item.getStartItem(); i++) {
                        if (p.getInventory().contains(item.reqItem[i]))
                            return true;
                    }
                }
            }
            return false;
        }
        public static checkItem(Player p) {
            for(UpgItem item : UpgItem.values()){
                    for (int i = 0; i < item.startItem; i++) {
                        if (p.getInventory().contains(item.startItem)) {
                            return item.startItem;
                        }
                    }
            }
        }
     }


        public static void init(Player p) {
            if (UpgItem.checkReq(p)) {
                World.sendMessage("GG");
            } else {
                World.sendMessage("Better Luck next time");
            }
        }
        public static void getItems() {

        }
    }
