#install.packages("Seurat") #if not currently installed must be installed first
vignette(SRAdb)


library(SRAdb) #access the SRA database library
sqlfile <-'SRAmetadb.sqlite' #allows us to access the database
if(!file.exists('SRAmetadb.sqlite')) sqlfile <<- getSRAdbFile() #create the sql and SRA
sra_con <- dbConnect(SQLite(),sqlfile) #connecting the SRA network

sraInf <- getSRAinfo("", sra_con, sraType = "sra")

sapply(sraInf$run, function(x) try(getSRAfile(x,sra_con, fileType = "sra"),silent=TRUE))



library(GEOquery) #obtaining the 
tmp <- getGEO("GSE74679")
gseInf <- pData(tmp[[1]])
gseInf



#running the pipeline for clustering data
library(dplyr) #import
library(Seurat) #import the Seurat library
library(patchwowrk) #import patchwork
vignette("SRAdb")

pbmc.data <- Read10X() #reading in Geo Data

pbmc <- CreateSeuratObject(coutns = pbmc.data, project "pbmc3k", mincells )
