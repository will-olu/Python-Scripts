from Bio import Entrez


#term refers to the name of the value or input
term = "Englerophytum"
#the start is the variable we will use to determine where the count for the values start
start = "2007/03/29"
#this is the last time that will be included in the search for the fasta files
end = "2010/12/13"

#email for Entrez data entry
Entrez.email = 'aoluajeigbe@luc.edu'
#handle takes in the search values for the nucleotide values
#it then looks at the term value createdand looks for Organism and the PDAT value at the start and end
handle = Entrez.esearch(db="nucleotide", term='"' + term + '"[Organism] AND ("' + start + '"[PDAT] : "' + end + '"[PDAT])"')
#record takes the input after reading the values that have beeen searched in the handle variable
record = Entrez.read(handle)
#prints the count of the variable that are present in the FASTA format
print (record["Count"])
