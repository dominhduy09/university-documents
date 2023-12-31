clear all; close all; clc;

A=[1 2 3;4 5 6;7 8 9]
B=A(:,2:3)             %question a
C=A(1:2,:)             %question b
D=B*C                  %question c
E = max(D)             %question d 
[F, ind] = min(D,[],2) %question e
E*F