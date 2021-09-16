
library(dplyr)
library(Seurat)
library(patchwork)


library(Matrix)
data_dir <- ''
list.files(data_dir) # Should show barcodes.tsv, genes.tsv, and matrix.mtx
expression_matrix <- Read10X(data.dir = data_dir)
seurat_object = CreateSeuratObject(counts = expression_matrix)

