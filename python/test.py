from datasets import load_dataset

jsonl_file = "dataset.jsonl"

dataset= load_dataset("json", data_files=jsonl_file)