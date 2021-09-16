install.packages("seqinr")
install.packages("ade4")
library(ade4)
library(seqinr)

#Read in the data in Fasta format



gene <- system.file("C:/Users/willi/Downloads/Ecoli Data (1)/Ecoli Data/AE005174v2.fas", package = "seqinr") 
x<-c read.fasta (file = gene, as.string = TRUE, seqtype = "AA")

#This is the DNA sequence of ecoli!
ecoli<-c(x[[1]],x[[2]])
