cd ..;
if [[ $# -eq 0 ]] ;
  then
    java -cp target/ParkingLot-1.0-SNAPSHOT.jar com.parking.MainApp
  else
    java -cp target/ParkingLot-1.0-SNAPSHOT.jar com.parking.MainApp "$1";
fi