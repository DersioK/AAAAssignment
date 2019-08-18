class Element implements  Comparable<Element>{
    public final int index;
    public final double distance;

    public Element(int index, double distance){
        this.index = index;
        this.distance = distance;
    }
    @Override
    public int compareTo(Element e){
        return Double.valueOf(this.distance).compareTo(Double.valueOf(e.distance));
    }
}