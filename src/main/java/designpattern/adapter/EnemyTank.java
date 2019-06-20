package designpattern.adapter;

public class EnemyTank implements EnemyAttacker{
    @Override
    public void fireWeapon() {
        System.out.println("Firing weapon from Tank");
    }

    @Override
    public void driveForward() {
        System.out.println("Tank is moving forward");
    }

    @Override
    public void assignDriver(String name) {
        System.out.println("Tank has assigned a driver "+name);
    }
}
