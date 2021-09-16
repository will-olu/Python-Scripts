from Bio import Seq
from Bio import SeqIO
# coding=utf-8

def readFile(filePath):
    with open(filePath, 'r') as f:
        return[l.strip() for l in f.readlines()]

File = readFile(r"rosalind_grph.txt")

FDict = {}

FastLabel = ""

for line in File:
    if '>' in line:
        FastLabel = line
        FDict[FastLabel] = ""
    else:
        FDict[FastLabel] += line

data = FDict
#print(FDict)


 
# method1

 
#function to look at the Kmer overlap on different values
def is_k_overlap(s1, s2, k):
    #here at s1 we are pulling the values that are from -k the right side til the end
    #for s2 we are looking for the same values from the compliment from 0 to k 
    return s1[-k:] == s2[:k]
 
#importing itertools to help iteraate over the strings that are creating
import itertools
 
#this function inputs our data that we are getting from Rosalind and lets us parse the file
def k_edges(data, k): # two inputs are the k values and the data set that we plan on using
    edges = [] #creation of an empty set to hold our data more comfortably
    #u and v are values within the data that we will use to parse the file to get specific names of values
    for u, v in itertools.combinations(data, 2):  #a for loop is created to manipulate the combination of values
        #u data and v data are created respectively from the u-dna and v_dna
        u_dna, v_dna = data[u], data[v]
        print(u_dna, v_dna)
 #conditional that looks ar where u_dna and v_dna overlap and connects those edges
        if is_k_overlap(u_dna, v_dna, k):
            edges.append((u, v))
 #this does the same thing but with respect to the v_dna connecting the values and returns the value into an empty string
        if is_k_overlap(v_dna, u_dna, k):
            edges.append((v, u))
 #this breaks the function and provides us with the edges we were creating.
    return edges
 
#print the kmers from our data taking tri-mers
print (k_edges(data, 3))
