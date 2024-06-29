I = imread("C:\Users\domin\name.png");
I = im2gray(I);

figure
imshow(I)

% Run OCR on the image
results = ocr(I);

results.Text