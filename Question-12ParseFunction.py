

#function to read the file
def readFile(filePath):
    #using open function to opoen the file in the filepath 
    with open(filePath, 'r') as f:
        return[l.strip() for l in f.readlines()]

#read file in from the rosalind file
File = readFile(r"rosalind_grph (3).txt")

#creating an empty set 
FDict = {}

#creating a FastLabel into an empty set
FastLabel = ""

j = 0
for line in File:
    if '>' in line:
        FastLabel = line
        FDict[FastLabel] = ""
#creation of the dictionary file 
    else:
        FDict[FastLabel] += line
#setting the FDict as the data for our set and printing the dictionary for review
data = FDict
#print(FDict)





 
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
        #print(u_dna, v_dna)
 #conditional that looks ar where u_dna and v_dna overlap and connects those edges
        if is_k_overlap(u_dna, v_dna, k):
            edges.append((u, v))
 #this does the same thing but with respect to the v_dna connecting the values and returns the value into an empty string
        if is_k_overlap(v_dna, u_dna, k):
            edges.append((v, u))
 #this breaks the function and provides us with the edges we were creating.
    return edges
 
#print the kmers from our data taking tri-mers
#print (k_edges(data, 3))

mylist = (k_edges(data, 3))#creating a variable to use a print for loop
for elem in mylist:
    if elem == ">":
        elem[0] = elem[0].replace(">", "")
    else:
        elem[0] = elem[0].strip('>')
        print(*elem, sep = ' ')#seperate the elements
        print(elem.strip('>'))
      
     
        
