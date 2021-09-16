
from Bio import Entrez

geneName = "Anthoxanthum"
pubDateStart = "2003/7/25"
pubDateEnd = "2005/12/27"
searchTerm = f'({geneName}[Organism]) AND("{pubDateStart}"[Publication Date]: "{pubDateEnd}"[Publication Date])'

print(f"\n[GenBank gene database]:")
Entrez.email = "aoluajeigbe@luc.edu"
handle = Entrez.esearch(db="nucleotide", term=searchTerm)
record = Entrez.read(handle)
print(record["Count"])
