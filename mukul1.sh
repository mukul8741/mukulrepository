addition()
{
   echo "Result : " $(($1+$2))
 }
echo "Welcome to the simple calculator"
while [ "$exits" != "exit" ]
do
echo "Enter first no "
read num1

echo "Enter number 2 " 
read num2

echo ""


echo "Operations Available"
echo ""
echo "Addition(Enter 1)" 
echo "Subtraction(Enter 2)" 
echo "Multiply(Enter 3)" 
echo "Divide(Enter 4)" 
echo "power(Enter 5)"
echo ""


pow=1;
read -p "Enter Choice " choice
echo ""

if (( $choice == 1 ))
then
    addition $num1 $num2

elif (($choice == 2))
then
    echo "Result : " $((num1-num2))

elif (($choice == 3))
then
    echo "Result : " $((num1*num2))

elif (($choice == 4));then
    echo "Result : " $((num1/num2))

elif (($choice == 5));then
    for((i=0;i<num2;i++))
    do
      pow=$((pow*num1))
    done
    echo "Result : " $pow

else
    echo "Wronge Choice"
fi

echo ""
echo "Enter 'exit' to Exit or 'C/c' to continue"
read exits

done
