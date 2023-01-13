public class Tax {
    public static int getTax(int nci) {
        if (nci <= 0) {
            return 0;
        }

        if (nci <= 50000) {
            return (int)(nci * 0.02);
        }

        int sum1 = (int)(50000 * 0.02);

        if (nci <= 100000) {
            return (int)(sum1 + (nci - 50000) * 0.06);
        }

        int sum2 = (int)(50000 * 0.06);

        if(nci <= 150000) {
            return (int)(sum1 + sum2 + (nci - 100000) * 0.1);
        }

        int sum3 = (int)(50000 * 0.1);
        if (nci <= 200000) {
            return (int)(sum1 + sum2 + sum3 + (nci - 150000) * 0.14);
        }

        int sum4 = (int)(50000 * 0.14);
        return (int)(sum1 + sum2 + sum3 + sum4 + (nci - 200000) * 0.17);

    }
}
