import java.io.*;
public class Aeroplani {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //sikur scanner

        String user, password, yn, search, again, choice;
        int to = 0, y = 1, z = 0, end = 0, r = 1;
        int available[] = new int[6]; //caktojm nr e ulseve te lira
        int pasagjere[][] = new int[100][3]; //pasagjeret qe kane mu ul ne ulese
        String emri[][] = new String[100][3]; //marrim varg dy dimensional per emrat(si username, destination)
        double cmimet[][] = new double[100][3]; //cmimi per ulese
        double pagesa[] = new double[6]; //cdo lloj pagese qe kan me ba
        double kusuri[] = new double[6]; //pjesa e parave qe kemi me i`a kthy

        for (int i = 1; i < 4; ) {
            System.out.println("Përdor nr. 1 si emri dhe passwordi fillestar");
            System.out.print("Shkruani emrin: ");
            user = in.readLine();
            System.out.print("Shkruani passwordin: ");
            password = in.readLine();

            //"available[]" a jan te lira uleset
            //store 6 seats every destination [1-5]//
            for (int o = 1; o <= 5; o++) {
                available[o] = 6;
            }

            //nese e jep emrin edhe passin mir vazhdo te MAIN MENU//
            if (user.equals("1") && password.equals("1")) {
                for (int x = 1; x == 1; ) {
                    //the MAIN MENU//
                    System.out.println("/////////////////////////////////////////");
                    System.out.println("........................................");
                    System.out.println("..     Airline Seats Reservation      ..");
                    System.out.println("........................................");
                    System.out.println(".. [1] Destinacionet e mundëshme      ..");
                    System.out.println(".. [2] Ulëset për pasangjerë          ..");
                    System.out.println(".. [3] Pagesat                        ..");
                    System.out.println(".. [4] Aplikacioni i juaj            ..");
                    System.out.println(".. [5] Exit                          ..");
                    System.out.println("........................................");
                    System.out.println("////////////////////////////////////////\n");

                    for (x = 1; x == 1; ) {
                        System.out.print("Zgjedhja juaj: ");
                        choice = in.readLine();

                        //if CHOICE osht 1 qite Destinacionet//
                        if (choice.equals("1")) {
                            //Detajet e Destinacioneve//
                            //Shfaqe Destinacionin, cmimet, edhe uleset//
                            System.out.println("///////////////////////////////////////");
                            System.out.println(".......................................");
                            System.out.println("..  Destinacioni |  Cost  |  Seat    ..");
                            System.out.println(".......................................");
                            System.out.println(".. 1.)Geneva      | 118 EUR|   " + available[1] + "    ..");
                            System.out.println(".. 2.)New York    | 549 EUR|   " + available[2] + "    ..");
                            System.out.println(".. 3.)London      | 134 EUR|   " + available[3] + "    ..");
                            System.out.println(".. 4.)Istambul    | 109 EUR|   " + available[4] + "    ..");
                            System.out.println(".. 5.)Canada      | 900 EUR|   " + available[5] + "    ..");
                            System.out.println(".......................................\n");
                            System.out.println("Penzionistët, Studentët, Invalidë të luftës (fëmijët e invalidëve), Veteran të luftës (fëmijët e veteranëve) përfitojnë 20% zbritje!!!\n");
                            x = 0;
                        }

                        //Nese 2 shfaqi uleset per blerje//
                        else if (choice.equals("2")){
                            int print=1;
                            //mas pari destinacionet//
                            System.out.println("///////////////////////////////////////");
                            System.out.println(".......................................");
                            System.out.println("..   Destinacioni |  Cost  |  Seat   ..");
                            System.out.println(".......................................");
                            System.out.println(".. 1.)Geneva      | 118 EUR|   " + available[1] + "    ..");
                            System.out.println(".. 2.)New York    | 549 EUR|   " + available[2] + "    ..");
                            System.out.println(".. 3.)London      | 134 EUR|   " + available[3] + "    ..");
                            System.out.println(".. 4.)Istambul    | 109 EUR|   " + available[4] + "    ..");
                            System.out.println(".. 5.)Canada      | 900 EUR|   " + available[5] + "    ..");
                            System.out.println(".........................................\n");
                            System.out.println("Penzionistët, Studentët, Invalidë të luftës ( fëmijë, Veteran të luftes (fëmijët e veteranëve) perfitojne 20% zbtritje!!!\n");

                            //nese skena ma bileta
                            if((available[1]==0)&&(available[2]==0)&&(available[3]==0)&&(available[4]==0)&&(available[5]==0)){
                                System.out.println("Më vjen keq, nuk kemi mjaftueshëm bileta për atë vend!");
                                x=0;
                            }

                            //inputting emrin e pasagjerit//
                            else{
                                for(x=1; x==1;){
                                    System.out.print("\nShkruani emrin e pasagjerit: ");
                                    emri[z][0] = in.readLine();
                                    x=0;
                                    //Nese e ka perdor niher, qite error//
                                    for(int l=0; l<z; l++){
                                        if(emri[l][0].equalsIgnoreCase(emri[z][0])){
                                            System.out.println("Më vjen keq, ky emër është përdorur njëherë!");
                                            x=1;
                                        }
                                    }
                                }

                                //Destinacionet//
                                //veq me nr [1-5]//
                                for(x=1; x==1;){
                                    System.out.print("Shkruani destinacionin: ");
                                    to = Integer.parseInt(in.readLine());

                                    //nese "<1" ose ">5", qite error//
                                    if(to<1 || to>5){
                                        System.out.println("Keni shtypyr gabim!!!");
                                        x=1;
                                    }
                                    //nese skena ulse qite error edhe kthehu te inputi//
                                    for(int d=1; d<=5; d++){
                                        if(to==d){
                                            if(available[to]==0){
                                                System.out.println("Më vjen keq, nuk kemi ulëse në dispozicion!");
                                                x=1;
                                            }
                                            x=0;
                                        }
                                    }
                                }
                                //convert the integer to string//
                                String dest[] = { " ", "Geneva", "New York", "London", "Istambul", "Canada"};
                                double cost[] = { 0,118,549,134,109,900};

                                //converted integer to string
                                emri[z][1] = dest[to];
                                cmimet[z][0] = cost[to];

                                //inputing for Number of Passenger's//
                                for(x=1; x==1;){
                                    System.out.print("Sa pasagjerë jeni: ");
                                    pasagjere[z][0] = Integer.parseInt(in.readLine());

                                    //zbriti uleset nese i kan ble//
                                    for(int p=1; p<=5; p++){
                                        if(to==p){
                                            print=1;
                                            available[to] = available[to]-pasagjere[z][0];

                                            //nese osht 0 qite error//
                                            //shtoja nr e inputit te ajo qe e kena zbrit per met dal ulsja back the original seat//
                                            //qiti ulset e lira edhe kthehu fillim//
                                            if(available[to]<0){
                                                System.out.print("Kërkojmë falje nuk kemi ulëse të lira për " +pasagjere[z][0] +" persona\n");
                                                available[to] = available[to]+pasagjere[z][0];
                                                System.out.print("Ne kemi vetëm " +available[to] +" ulëse të lira\n");
                                                x=1;
                                                print=0;
                                            }
                                            else{
                                                x=0;
                                            }
                                        }
                                    }

                                }

                                //pasagjeret qe kane perfitu zbritje//
                                for(x=1;x==1;){
                                    System.out.print("Sa pasagjerë do të përfitojnë zbritje: ");
                                    pasagjere[z][1] = Integer.parseInt(in.readLine());

                                    if(pasagjere[z][1]>pasagjere[z][0]){

                                        System.out.println("Keni shtypyr gabim!!!");
                                        System.out.println("Numrat e pasagjerëve janë vetëm " +pasagjere[z][0] +"!");
                                        x=1;
                                    }
                                    else{
                                        break;
                                    }
                                }
                                //print out of passengers details....
                                if(print==1){
                                    System.out.println("\n/////////////////////////////////////////////");
                                    System.out.println(".........................................");
                                    System.out.println("..      Të dhënat mbi pasagjerin       ..");
                                    System.out.println(".........................................");
                                    System.out.println(".. Emri: " + emri[z][0] +"                        ..");
                                    System.out.println(".. Destinacioni i pasagjerit: " + emri[z][1] + "   ..");
                                    System.out.println(".. Cmimi i biletës: EUR " + cmimet[z][0] + "          ..");
                                    System.out.println(".. Numri i pasagjerëve: " + pasagjere[z][0] + "              ..");
                                    System.out.println(".. Numri i pasagjerëve me përfitim zbritjeje: " + pasagjere[z][1] + "..");
                                    System.out.println(".........................................");
                                    System.out.println("/////////////////////////////////////////////\n");
                                    emri[z][2]="0";
                                    double discount=(cmimet[z][0]-(cmimet[z][0]*0.2))*pasagjere[z][1];
                                    cmimet[z][2]= ((pasagjere[z][0]-pasagjere[z][1])*cmimet[z][0])+discount;
                                    x=0;
                                }
                                z++;
                            }
                        }
                        else if (choice.equals("3")){
                            for(x=1; x==1;){
                                System.out.print("Shkruani emrin e pasagjerit: ");
                                search = in.readLine();
                                int s=1;
                                for(int b=0;b<z;b++){
                                    if(search.equalsIgnoreCase(emri[b][0])){
                                        System.out.println("////////////////////////////////////////////////");
                                        System.out.println("...........................................");
                                        System.out.println("..       Të dhënat mbi pasagjerin        ..");
                                        System.out.println("...........................................");
                                        System.out.println(".. Emri: " + emri[b][0] + "                          ..");
                                        System.out.println(".. Destinacioni i pasagjerit: " + emri[b][1] + "     ..");
                                        System.out.println(".. Cmimi i biletës: EUR" + cmimet[b][0] + "             ..");
                                        System.out.println(".. Numri i pasagjerëve: " + pasagjere[b][0] + "                ..");
                                        System.out.println(".. Numri i pasagjereve me perfitim zbritjeje: " + pasagjere[b][1] + " ..");
                                        System.out.println("...........................................");
                                        System.out.println("////////////////////////////////////////////////");
                                        s=0;
                                        x=0;

                                        if(emri[b][2].equals("x")){
                                            System.out.println("Pasagjeri ka paguar!");
                                            x=0;
                                        }
                                        else{
                                            emri[b][2]="x";


                                            for(x=1; x==1;){
                                                System.out.println("\nCmimi total i pasagjerit: EUR "+cmimet[b][2]);
                                                System.out.print("Shkruani shumën që do të jepni: ");
                                                pagesa[b] = Double.parseDouble(in.readLine());
                                                kusuri[b]=pagesa[b]-cmimet[b][2];

                                                if(kusuri[b]<0){
                                                    System.out.println("Keni shtypyr gabim!!!");
                                                    x=1;
                                                }
                                                else{
                                                    System.out.println("Kusuri: EUR "+kusuri[b]);
                                                    System.out.println("");
                                                    x=0;
                                                }
                                            }
                                        }
                                    }
                                }
                                if (s==1){
                                    System.out.println("\nEmri i pasagjerit nuk u gjet!\n");
                                    for(int q=1; q==1;){

                                        System.out.print("A dëshironi dicka tjetër? [y/n]: ");
                                        again=in.readLine();

                                        if(again.equalsIgnoreCase("y")){
                                            q=0;
                                        }
                                        else if (again.equalsIgnoreCase("n")){
                                            q=0;
                                            x=0;

                                        }
                                        else{
                                            System.out.println("\nKeni shtypyr gabim!!!\n");
                                        }


                                    }
                                }
                            }

                        }

                        else if (choice.equals("4")){


                            for(int sx=1; sx<=3;){
                                System.out.print("Shkruani emrin e pasagjerit: ");
                                search = in.readLine();

                                int s=1;
                                for(x=0; x<=z; x++){
                                    if(search.equalsIgnoreCase(emri[x][0])){
                                        System.out.println("//////////////////////////////////////////");
                                        System.out.println("..........................................");
                                        System.out.println("..      Të dhënat mbi pasagjerin        ..");
                                        System.out.println("..........................................");
                                        System.out.println(".. Emri: " + emri[x][0] +  "                         ..");
                                        System.out.println(".. Destinacioni i pasagjerit : " + emri[x][1] + "   ..");
                                        System.out.println(".. Cmimi i biletës: EUR" + cmimet[x][0] + "            ..");
                                        System.out.println(".. Numri i pasagjerëve: " + pasagjere[x][0]+ "               ..");
                                        System.out.println(".. Numri i pasagjereve me perfitim zbritjeje: " + pasagjere[x][1] + "..");
                                        System.out.println(".. Cmimi total: EUR " + cmimet[x][2] + "               ..");
                                        if(emri[x][2].equals("x")){
                                            System.out.println("..............................");
                                            System.out.println(".. Pagesa: EUR " +pagesa[x] + "        ..");
                                            System.out.println(".. Kurusi: EUR " +kusuri[x] + "         ..");
                                            System.out.println(".. Gjendja: E paguar!" +   "       ..");
                                            System.out.println("..............................");
                                        }
                                        else{
                                            System.out.println("...............................");
                                            System.out.println(".. Gjendja: Nuk keni paguar! ..");
                                            System.out.println("...............................");
                                        }
                                        s=0;
                                        sx=4;
                                    }
                                }

                                if (s==1){
                                    System.out.println("Emri i pasagjerit nuk është gjetur");
                                    sx++;
                                }

                            }
                        }

                        else if(choice.equals("5")){
                            end=1;
                            x=0;
                            System.out.println("Faleminderit!");
                        }

                        else{
                            System.out.println("Keni shtypyr gabim!!!");
                            x=1;
                        }
                    }

                    for(y=1; y==1;){
                        if(end==1){
                            break;
                        }
                        System.out.print("A dëshironi dicka tjetër? [y/n]: ");
                        yn = in.readLine();

                        if (yn.equalsIgnoreCase("y")){
                            x=1;
                            y=0;
                        }
                        else if (yn.equalsIgnoreCase("n")){
                            System.out.println("\nFaleminderit!!!");
                            break;
                        }
                        else{
                            System.out.println("Keni shtypyr gabim!!!");
                            y=1;
                        }
                    }
                }
                i=4;
            }
            else{
                System.out.println("\nEmri ose passwordi është gabim!\n");
                i++;
            }
        }
    }
}
