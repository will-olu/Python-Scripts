library(ade4)

dbinom(2, size = 14, prob = 0.6) # the initial value is the value of X in the function

pbinom(2, 14, 0.6)

#finding the P(X<2)

pbinom(1,14,0.6)

dbinom(0,14,0.6)+dbinom(1,14,0.6)

#finding quantiles
qbinom(0.25, 14,0.6) #quantile is the first number, the number of values n, and the probability is the last value

qbinom(0.71, 14,0.6)

#simulating or generating random values
rbinom(10, 14, 0.6) #random binomal first value is the number of values that you want to call

set.seed(123)

rbinom(10, 14, 0.6)

x <-
hist(x)
hist(rbinom(100,14,0.6))

s<-1000
m<-rep(0,1000) #storing sample means
for(i in 1: s){
  m[i] <- mean(rbinom(100, 14, 0.6))
}

hist(m)




