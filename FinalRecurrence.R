#install.packages("jsonlite", repos="https://cran.rstudio.com/")
library("jsonlite")

json_file <- 'https://datahub.io/machine-learning/breast-cancer/datapackage.json'
json_data <- fromJSON(paste(readLines(json_file), collapse=""))

# get list of all resources:
print(json_data$resources$name)

# print all tabular data(if exists any)
for(i in 1:length(json_data$resources$datahub$type)){
  if(json_data$resources$datahub$type[i]=='derived/csv'){
    path_to_file = json_data$resources$path[i]
    data <- read.csv(url(path_to_file))
    print(data)
  }
}

library(ftExtra)
library(dplyr)
#Clean-up step
#dropping inv.nodes, node.caps, and irradiat
data$inv.nodes <- NULL
data$node.caps <- NULL
data$irradiat <- NULL

#checking headers
head(data)

ageof40s<-subset(data, age == "40-49",na.action = na.omit)

matrixrecurrence<-table(ageof40s$deg.malig, ageof40s$Class)
matrixrecurrence


#no reccurent events = NRE, Reccurrent events = RE
#RE/90 = 0.3
#NRE/90 = 0.7

#transition states
#RE | RE = 0.3
#NRE | NRE = 0.7
#RE to NRE = 0.7
#NRE to RE = 0.3

#transition between the two 
#grade 1 for NRE 0.166 , grade 2 NRE 0.411, grade 3 NRE 0.122
#grade 1 for RE 0.03 , grade 2 RE 0.122, grade 3 NRE 0.144

#We can then test the likelihood of patients with reccurent events having a reccurent event
#and nonrecurrent event of their cancer another reason this group is effectual is that we can split the data in roughly 3 equal groups

#for non-reccurent events
NRE = (((0.5*0.166)*((0.166*0.7)^29)*((0.411*0.7)^30)*((0.122*0.7)^30)))
NRE #probability of equally distributed events
       
       
#for recurrent events
RE = ((0.5 * 0.03)*((0.03*0.3)^29)*((0.3*0.122)^30)*((0.3*0.144)^30))
RE #probability of equally distributed events

