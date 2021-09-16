install.packages("readxl")

install.packages("xslx")

install.packages("tidyverse")

library(readxl)



data1 <- read.csv("C:/Users/willi/OneDrive/Documents/dataset.csv")

# m = age

m <- age()

#specificity

specificity <- 

  #sensitivity represents the probability of the test missing the 
# Ps1-1=(Probability of having a negative Screening)
# P11 = Probability of being cancer free at m
# P12 = Probability of preclinical cancer at age m

# ((P11(m) x specificity + P12(m) x (1 - sen))/ P11(m) +p12(m)

# Ps1-2 = probability of a positive screening)
  
#Ps1-2 = P11(m) x (1-specificity) + P12(m) x sensitivity/ P11(m) + P12(m)

#i1 = normal
#i2 = preclinical cancer
#i3 = clinical cancer

pi<-(1,2,3)


#j = 1 normal
#j = 2 preclinical localized cancer
#j = 3 
#j = 4
#j = 5

pi <-c (1,2,3,4,5)
