package eg.edu.alexu.csd.datastructure.LinkedLists.cs18011305_18011304;

import static java.lang.Math.pow;

public class PolynomialSolver extends SingleLinkedList implements IPolynomialSolver {
    ILinkedList polynomial = new SingleLinkedList();

    ILinkedList A = new SingleLinkedList();
    ILinkedList B = new SingleLinkedList();
    ILinkedList C = new SingleLinkedList();
    ILinkedList result = new SingleLinkedList();

    public class PolyTerm {
        int coeff;
        int expo;
        public PolyTerm(int coeff, int expo) {
            this.coeff = coeff;
            this.expo = expo;
        }


        public int getCoeff() {
            return coeff;
        }

        public int getExpo() {
            return expo;
        }
    }

    @Override
    public void setPolynomial(char poly, int[][] terms) {
        for (int i = 0; i < terms.length; i++) {
            PolyTerm temp = new PolyTerm(terms[i][0], terms[i][1]);
            getList(poly).add(temp);
        }
    }

    @Override
    public String print(char poly) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < (getList(poly).size())-1; i++) {
            PolyTerm temp = (PolyTerm) getList(poly).get(i);
            if (temp.expo != 0) {
                builder.append(temp.coeff + "x^" + temp.expo + "+");
            } else {
                builder.append(temp.coeff + "+");
            }
        }
        PolyTerm temp = (PolyTerm) getList(poly).get(getList(poly).size());
        if (temp.expo != 0) {
            builder.append(temp.coeff + "x^" + temp.expo);
        } else {
            builder.append(temp.coeff);
        }
        return builder.toString();
    }

    @Override
    public void clearPolynomial(char poly) {
        getList(poly).clear();
    }

    @Override
    public float evaluatePolynomial(char poly, float value) {
        float result = 0;
        for (int i = 0; i < getList(poly).size(); i++) {
            PolyTerm temp = (PolyTerm) getList(poly).get(i);
            result += temp.coeff * (pow(value , temp.expo));
        }
        PolyTerm temp = (PolyTerm) getList(poly).get(getList(poly).size());
        return result;
    }

    @Override
    public int[][] add(char poly1, char poly2) {
        int i = 0, j = 0;
        ILinkedList list1 = getList(poly1);
        ILinkedList list2 = getList(poly2);
        while (list1.get(i) != null && list2.get(j) != null) {
            PolyTerm first = (PolyTerm) list1.get(i);
            PolyTerm second = (PolyTerm) list2.get(j);
            PolyTerm res;
            if (first.expo > second.expo) {
                res = new PolyTerm(first.coeff, first.expo);
                i++;
            } else if (first.expo < second.expo) {
                res = new PolyTerm(second.coeff, second.expo);
                j++;
            } else {
                res = new PolyTerm(first.coeff + second.coeff, first.expo);
                i++;
                j++;
            }
            result.add(res);
        }
        if (list1.get(i) != null) {
            while (list2.get(j) != null) {
                PolyTerm res;
                PolyTerm second = (PolyTerm) list2.get(j);
                res = new PolyTerm(second.coeff, second.expo);
                result.add(res);
                j++;
            }
        } else {
            while (list1.get(i) != null) {
                PolyTerm res;
                PolyTerm first = (PolyTerm) list1.get(i);
                res = new PolyTerm(first.coeff, first.expo);
                result.add(res);
                i++;
            }
        }
        return listToArray(result);
    }

    @Override
    public int[][] subtract(char poly1, char poly2) {
        int i = 0, j = 0;
        ILinkedList list1 = getList(poly1);
        ILinkedList list2 = getList(poly2);
        while (list1.get(i) != null && list2.get(j) != null) {
            PolyTerm first = (PolyTerm) list1.get(i);
            PolyTerm second = (PolyTerm) list2.get(j);
            PolyTerm res;
            if (first.expo > second.expo) {
                res = new PolyTerm(first.coeff, first.expo);
                i++;
            } else if (first.expo < second.expo) {
                res = new PolyTerm(-second.coeff, second.expo);
                j++;
            } else {
                res = new PolyTerm(first.coeff - second.coeff, first.expo);
                i++;
                j++;
            }
            result.add(res);
        }
        if (list1.get(i) != null) {
            while (list2.get(j) != null) {
                PolyTerm res;
                PolyTerm second = (PolyTerm) list2.get(j);
                res = new PolyTerm(-second.coeff, second.expo);
                result.add(res);
                j++;
            }
        } else {
            while (list1.get(i) != null) {
                PolyTerm res;
                PolyTerm first = (PolyTerm) list1.get(i);
                res = new PolyTerm(first.coeff, first.expo);
                result.add(res);
                i++;
            }
        }
        return listToArray(result);
    }

    @Override
    public int[][] multiply(char poly1, char poly2) {

        return new int[0][];
    }
    private ILinkedList getList(char poly) {
        switch (poly) {
            case 'A': return A;
            case 'B': return B;
            case 'C': return C;
            default: throw new RuntimeException("Error");
        }
    }

    public int[][] listToArray (ILinkedList list) {
        int[][] retArray = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            PolyTerm temp = (PolyTerm) list.get(i);
            retArray[i][0] = temp.coeff;
            retArray[i][1] = temp.expo;
        }
        return retArray;
    }
}
