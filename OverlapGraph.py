from collections import OrderedDict
import re

def overlap_graph(dna,n): #this function takes in the variable dna(our rosalind fasta and n
    edges = [] #creation of empty set to be created by for loop
    for ke1, val1 in dna: #dictonary of values 
        for ke2, val2 in dna:     #
            if ke1 != ke2 and val1[-n:] == val2[0:n]: #condtional that if the k-mer and val at the end in the dataset(dna) are not equal and the reverse of val1 and val2 are equal append the values
               edges.append(ke1+'\t'+ke2) #this brings together the edges
    return edges

seq = OrderedDict() #the sequence will now become an Ordered dictionary that we imported from collections

with open (r"rosalind_grph (6).txt", 'r') as f: #creation of file
     for line in f: #forloop
         line = line.rstrip()
         if line.startswith('>'): #removing the > in the seqName with a conditional
            seqName = re.sub('>','',line)
            seq[seqName] = ''
            continue
         seq[seqName] += line.upper()  #continuing to iterate the values

dna =seq.items()#puts the seq.items that were created into our dna dataset

fh = open('rosalind_grph_output.txt', 'wt') #file to hold values

for x in overlap_graph(dna,3): #creates a for loop making a new line for each value in the set
    fh.write(x+'\n')

fh.close()
