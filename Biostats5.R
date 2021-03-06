x <-c (30, 73, 40, 47, 25, 82, 60, 56, 43, 50, 59, 4, 22, 33, 20, 32, 36, 69, 47, 22, 11, 19, 67, 43, 41)

mean(x) # 41.24
sd(x) #20.1024
qt(0.995, df = 24) #2.79694
qnorm(0.995) #2.575829

41.24 - 2.575829*20.1024/sqrt(25)
41.24 + 2.575829*20.1024/sqrt(25)

y <- c (8, 5, 12, 4, 11, 6, 8, 7, 7, 12, 7, 3, 11, 14, 11, 9, 6, 6, 5, 6, 10, 14, 4, 5, 5)

mean(y)
sd(y)
qt(0.95, df = 24)


qnorm(0.95) #1.959964
7.84 - 1.710882*3.2104/sqrt(25)
7.84 + 1.710882*3.2104/sqrt(25)

qt(0.975, df = 68) #1.995469
qt(0.975, df = 101) # 1.983731

#CREATININE
0.97 - 1.983731*0.22/sqrt(102)
0.97 + 1.983731*0.22/sqrt(102)

#Potassium
4.43 - 1.983731*0.64/sqrt(102)
4.43 + 1.983731*0.64/sqrt(102)

#Phosphate
1.68 - 1.983731*0.47/sqrt(102)
1.68 + 1.983731*0.47/sqrt(102)

#Pyschological
36.50 - 1.983731*16.08/sqrt(102)
36.50 + 1.983731*16.08/sqrt(102)



#creatinine
1.00 - 1.995469*0.19/sqrt(69)
1.00 + 1.995469*0.19/sqrt(69)

#potassium
4.49 - 1.995469*0.71/sqrt(69)
4.49 + 1.995469*0.71/sqrt(69)

#phosphate
1.57 - 1.995469*0.40/sqrt(69)
1.57 + 1.995469*0.40/sqrt(69)

#Psychological
23.27 - 1.995469*13.79/sqrt(69)
23.27 + 1.995469*13.79/sqrt(69)


qnorm(0.975)

7.0 + 1.959964 * 2/sqrt(250)
7.0 - 1.959964 * 2/sqrt(250)


7.0 + 1.959964 * 2/sqrt(25)


qt(0.95, df = 29)


qt(0.99,df=29)


3.3+1.699127 *1.4/sqrt(30)
3.3-1.699127 *1.4/sqrt(30)

3.3+2.462 *1.4/sqrt(30)
3.3-2.462 *1.4/sqrt(30)

qt(0.01, df =99)


qt(0.975, df = 27)
0.84380 + 2.051831 * 0.1140/ sqrt(28)
0.84380 - 2.051831 * 0.1140/ sqrt(28)

qt(0.975, df = 31)
1.7927 + 2.039513 * 0.2834/sqrt(32)
1.7927 - 2.039513 * 0.2834/sqrt(32)

qt(0.975, df =24)
0.7044 + 2.063899 * 0.1076/ sqrt(25)
0.7044 - 2.063899 * 0.1076/ sqrt(25)


pnorm(50.495, 47, 2.33)


1 - pnorm(49, 47, 2.33)
pnorm(44, 47, 2.33)
