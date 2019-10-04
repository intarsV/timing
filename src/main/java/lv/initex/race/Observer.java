package lv.initex.race;




public interface  Observer {



    public void update();



//    void printArmy(List<ArmyUnit> army) {
//        Double totalCost = 0.0;
//        for (ArmyUnit armyUnit : army) {
//            System.out.println(armyUnit.getUnitType() + " --- " + armyUnit.getDescription()
//                    + " --- unit cost: " + armyUnit.cost());
//            totalCost += armyUnit.cost();
//        }
//        System.out.println("Total army cost: " + totalCost);
//    }


}
