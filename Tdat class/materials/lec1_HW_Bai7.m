clear all;
close all;

tong = 0;
tich = 1;
for i=1:1:5
   
   tich = 5 * i^3;
   tong = tong +  tich;
end
tong
k = 1:5;
tongthuc = sum(5.*k.^3) % using vectorlization 