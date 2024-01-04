package TPG37;

public record Sword(Material material, Gemstone gemstone, int lengthInCm, int crossguardWidthInCm) {
    public static void main(String[] args) {
        Sword basicSword = new Sword(Material.IRON, Gemstone.NO, 85, 15);
        Sword diamondSword = basicSword.withGemstone(Gemstone.DIAMOND);
        Sword broadSword = basicSword.adaptWidth(20);
        Sword TPS = new Sword(Material.BINARIUM, Gemstone.BITSTONE, 90, 17);

        System.out.println("The Basic Sword: " + basicSword);
        System.out.println("The Diamond Sword: " + diamondSword);
        System.out.println("The Broadsword: " + broadSword);
        System.out.println("The True Programmer's Sword: " + TPS);
    }

    private Sword adaptWidth(int newWidth) {
        return new Sword(this.material, this.gemstone, this.lengthInCm, newWidth);
    }

    private Sword withGemstone(Gemstone newGemstone) {
        return new Sword(this.material, newGemstone, this.lengthInCm, this.crossguardWidthInCm);
    }

    private Sword adaptLength(int newLength) {
        return new Sword(this.material, this.gemstone, newLength, this.crossguardWidthInCm);
    }

    private Sword withMaterial(Material newMaterial) {
        return new Sword(newMaterial, this.gemstone, this.lengthInCm, this.crossguardWidthInCm);
    }

    @Override
    public String toString() {
        if (this.gemstone != Gemstone.NO)
            return "a " + this.material.toString().toLowerCase() + " sword of " + this.lengthInCm +
                    " centimetres long, a crossguard width of " + this.crossguardWidthInCm + " centimetres, and an embedded " + this.gemstone + ".";
        else return "a " + this.material.toString().toLowerCase() + " sword of " + this.lengthInCm +
                " centimetres long and a crossguard width of " + this.crossguardWidthInCm + " centimetres.";
    }
}
