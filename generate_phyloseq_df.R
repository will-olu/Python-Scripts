#creating metadata for 
samples.out <- rownames(seqtab.nochim)
subject <- sapply(strsplit(samples.out, "D"), `[`, 2)
sample <- substr(subject,9,10)
time <- as.integer(substr(subject,6,7))
drug <- sapply(strsplit(samples.out, "-"), `[`, 2)
replicate <- substr(subject,10,10)
tube <- substr(subject, 9,9)
sample_type <- c("Control_t00", "Control_t00", "Contam_t24", "Contam_t24", "Contam_t24", "Negative_t24",
                 "Negative_t24","Negative_t24", "Solvent_t24", "Solvent_t24", "Solvent_t24", "0.1x_t24", 
                 "0.1x_t24", "0.1x_t24", "1x_t24", "1x_t24", "1x_t24", "10x_t24", "10x_t24", "10x_t24", "Contam_t24", "Contam_t24", "Contam_t24", "Negative_t24","Negative_t24","Negative_t24", "Solvent_t24", "Solvent_t24", "Solvent_t24", "0.1x_t24", "0.1x_t24", "0.1x_t24", "1x_t24", "1x_t24", "1x_t24", "10x_t24", "10x_t24", "10x_t24")

meta_df <- data.frame(Drug=drug, Sample=sample, Time=time, Tube = tube, Replicate = replicate, Sample_type = sample_type)
meta_df$Day <- "Day 1"
meta_df$Day[meta_df$Time>70] <- "Day 3"
rownames(meta_df) <- samples.out