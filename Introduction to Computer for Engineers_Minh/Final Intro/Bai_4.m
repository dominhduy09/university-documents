% Bai_4

clear all
clc
count=0;

[name HW1 HW2 HW3 HW4 HW5 HW6 HW7 Mid Final]=textread('grade.txt','%s %f %f %f %f %f %f %f %f %f');

for i=1:length(HW1)
    total_grade(i)=mean([HW1(i),HW2(i),HW3(i),HW4(i),HW5(i),HW6(i),HW7(i)])*0.3+Mid(i)*0.3+Final(i)*0.4;
    if total_grade (i)<50
        count=count+1;
    end
end
count

