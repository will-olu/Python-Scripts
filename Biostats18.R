#how to define vectors
X.vex <-c(4,1,3,8,6,7,5,3,0,9)
#call the vector
X.vec

str(X.vec) #what type of variable is this?
X.vec[1] #call specific elements of the vector
X.vec[1:5] #first 5 componenets

Y.vec <-c(1:10) #defines it
Y.vec #calls it

#check if the lenths are compatible
length(x.vec)



#arithmetic
X.vec +Y.vex
#to store the sum
z<-X>vec +Y.vec
X.vec +1

round(1/x.vec,4) [5:10]

c(1:3)+c(1:6)
c(1:3) +c(1:5)
###

# "==" this is a condition that asks if the value is true
X.vec ==0
X.vec == 0 +0
sum(x.vec == 0) #For how many times is this value true is done in

#conditions check if it is greater than 5 or equal to 0
X.vec>5 |X.vec ==0

#missing values
X.vec<-c(4,1,3,8,6)
X.vec[1]<-NA

is.na(X.vec) #checks for missing values is fuction lets us look for a specific value

#useful vector vector functions
seq(1,10,2)
seq(1,10, length = 5)#giving 5 random numbers within the range that are equally distanced

rep(0.5) # replicate the first value and the second value is the number of repetitions
c((rep(1,10,2), 2))

X<-c("A","A", "B", "C","A", "B",)

X[1 # gives first index
X[1:4] #gives the first 4 indices
str(x)#gives the type and length of the value

x<-c("1","1","2",,"2","3","1","2",)
X+1
as.numeric(X)+1 #change a non-numeric vector
X<-as.numeric(X) #You can permanently change the values into numeric values

X.factor("A","A", "B", "C","A", "B",)
X.factor
levels(X.factor) #denotes the unique values in the set
as.numeric(X>factor) #Change to numbers A would be 1 and B as 2 and so forth

Y.factor<-factor(c("100,100,200,300,100,200"))
Y.factor
levels(Y.factor)

as.numeric(Y.factor) # produces only the first value
as.numeric(as.character(Y.factor)) #changes the values to get the charactor values and then those values as numbers

#WORKING WITH SUBSETS
X<-c(1:10,NA,NA)

X[X<3 | X>8] #creating a subset of values that are less than 3 or greater than 8

X[!is.na(X)]

Y<-X[X<3 | X>8] #We can store the values into a variable
Y<-Y[!is.na(Y)] #then this value can be manipulated using the desired function or method

#UNDERSTANDING MATRIXES

# when you are creating  a matrix you will need to call matix
#c(gives the number of values in the matrix, ncol gives the number of columns)
X.mat<matrix(c(1:9, ncol=3)) #will be written column wise
X.mat
X.mat <-matrix(c(1:9),ncol =3,byrow=TRUE) #changes from the default which is by column to values by row
X.mat

X.mat[1,1]
X.mat[1,] #gives the first row
X.mat[,1] #gives the first column
X.mat[c(1:3), -2] #dropping the second column


#COMBINING MATRICES
#cbind binds columns
#rbind binds rows

mat1<-matrix(1,ncol=2, nrow=2)
mat2<-matrix(2,ncol=2, nrow=2)
mat3<-matrix(3,ncol=2, nrow=2)

cbind(mat1,mat2,mat3)
rbind(mat1,mat2,mat3)


wide<-cbind(mat1,mat2,mat3) #creates a wide matrices
tall<-rbind(mat1,mat2,mat3) #stacks values on top
rbind(wide,cbind(tall,tall,tall)) #stacks the functions



###loading datasets
#loading data in r

data(iris)
head(iris)
dim(iris) #gives the number of values in the set and the total number of variables
str(iris) #gives us the data types and variables present

flower<- iris #changes the name of the file and how it is referenced

colnames(flower) #this and "names" gives the names of the columns that are present in the data set
summary(flower) #this gives you the statistic values in the summary function

flower$Sepal.width #gives all the values in a column

mean(flower$Sepal.width)
sd(flower$Sepal.width) #provides the specific standard deviation of the values in that column
var(flower$Sepal.width) #provides the variance of the values
summary(flower$Sepal.width) #gives statistical values on the width

hist(flower$Sepal.width, col = 'pink', main = "HIstogram of Sepal Width of Iris Data", xlab = "Sepal width", breaks = c(2,2.5,3.0,3.5,4.0)) # main gives you a title for your histogram, xlab gives the axis values and breaks creates histograms
  main = "Histogram of Sepal WIdth of Iris data"
  ylab = "Relative Frequency"
  breaks = c(2,3,4,5)

flowers$Species

#Calling the species versicolor
#Addition of species vector is the flower versicolor or not//new variable

flowers$versi<-ifelse(flowers$Species =="versicolor", 1.0) 
#flowers <-flowers[, -6]
head(flowers)

flowers$versi #creates a map of true and false statements that are 0=false and 1=true

  
x<-c(74, 89,80,93,64,67,72,70,66,85,89,81,81,
     71,74,82,85,63,72,81,81,95,84,81,80,70,
     69,66,60,83,85,98,84,68,90,82,69,72,87,88)

#loading data onto your computer
dataa<-read.csv(#copy the location with forward slashes) #read command will bring in a file the dot directes the values towards the format that the data will be read into the folder with
#adding header= TRUE will tell the values that there is column names/ header = False removes the idea of column names

Gene1<-ldataa[1,] #prints the rows of values in the column
colnames(dataa) <c("all", "alla")
dim(dataa) #dimensions of the data sets
head(dataa) #the first set of data
mean(Gene1)

str(Gene1)
#if the value is a data frame which would make it a matrix now you need to change the values into a numerical set

Gene1<-as.numeric(dataa[1,])

Gene27<-as.numeric(leukemia[27,]) #creates a list at this column

summary(Gene27)

boxplot(Gene27)

vioplot(Gene27) # error
install.packages("vioplot")


library(vioplot)


#writing functions

f<-function(x){x*exp(-x)}*ifelse(x>0, 1, 0) #this how we write a function of a single variable and put the values that will change within brackets
#writing our conditions that exist require ifelse
f(2) #calling the functions

integrate(f, 0,2) #calculating the probability between the values of 0 and 2
integrate(f, 0, 1000000) #integrate the probability of a value towards infinity we are get the integral values

f<-function(x){x*exp(-x)*ifelse((x>=2&x<=5), 1,0)} #creates a set of conditions over the range of 2 and less than 5

h<-function(x,y=3) {(x+1)/(y+3)} #R cannot define functions that have 1+ unknown create a constant for the second value to make it able to work properly

h(1,2)

install.packages("ade4")
install.packages("seqinr")
library(ade4)
library(seqinr)
#Read in the data in Fasta format
#E. coli O157:H7
x<-read.fasta("C:/Users/swarnali/Documents/437/AE005174v2.fas")  #----> change this file location for your PC"
#This is the DNA sequence of ecoli!







