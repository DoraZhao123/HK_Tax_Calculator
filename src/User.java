public class User {
    private String firstName;
    private String lastName;
    private int age;

    private int income;

    // allowances
    private int basic;
    private boolean married;
    private int children;
    private int brotherSister;
    private boolean singleParent;
    private boolean disability;

    //deductions
    private int education;
    private int elderlyCare;
    private int loanInterest;
    private int retirement;
    private int mpf;

    // tax
    private int tax;

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.basic = 132000;

    }

    public void setIncome(int income) {
        this.income = income;
    }

    // m is y or n
    public void setMarried(String m) {
        if (m.equals("y")) {
            married = true;
        }
        else {
            married = false;
        }
    }

    public void setChildren(int children) {
        if (children > 9) {
            children = 9;
        }

        this.children = children;
    }

    public void setBrotherSister(int brotherSister) {
        this.brotherSister = brotherSister;
    }

    public void setSingleParent(String sp) {
        if (sp.equals("y")) {
            singleParent = true;
        }
        else {
            singleParent = false;
        }
    }

    public void setDisability(String d) {
        if (d.equals("y")) {
            disability = true;
        }
        else {
            disability = false;
        }
    }

    public void setEducation(int educatilon) {
        if (education > 10000) {
            education = 10000;
        }
        this.education = education;
    }

    public void setElderlyCare(int elderlyCare) {
        if (elderlyCare > 10000) {
            elderlyCare = 10000;
        }
        this.elderlyCare = elderlyCare;
    }

    public void setLoanInterest(int loanInterest) {
        if (loanInterest > 10000) {
            loanInterest = 10000;
        }
        this.loanInterest = loanInterest;
    }

    public void setRetirement(int retirement) {
        if (retirement > 18000) {
            retirement = 18000;
        }
        this.retirement = retirement;
    }

    public void setMPF(int mpf) {
        if (mpf > 60000) {
            mpf = 60000;
        }
        this.mpf = mpf;
    }

    private int getDeductions() {
       return (education + elderlyCare + loanInterest + retirement + mpf);
    }

    private int getAllowance() {
        int sum = basic;

        if(married) {
            sum = sum + 264000;
        }

        sum = sum + 120000 * children;

        sum = sum + 37500 * brotherSister;

        if(singleParent) {
            sum = sum + 132000;
        }

        if(disability) {
            sum = sum + 75000;
        }

        return sum;

    }

    // Net Chargeable Income = Income – Deductions – Allowances
    public int getNCI() {
        return this.income - getDeductions() - getAllowance();
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public String toString() {
        String str = this.firstName + "," + this.lastName + "," + this.age + "," + this.income + ",";
        if (this.married){
            str += "y, ";
        }
        else {
            str += "n, ";
        }
        str += this.children + "," + this.brotherSister + ",";
        if (this.singleParent) {
            str += "y,";
        }
        else {
            str += "n,";
        }
        if (this.disability) {
            str += "y,";
        }
        else {
            str += "n, ";
        }
        str += this.education + "," + this.elderlyCare + "," + this.loanInterest + ","
                + this.retirement + "," + this.mpf + "," + this.tax;
        return str;
    }


}
