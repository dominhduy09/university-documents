clear all; close all; clc;

% Cumsum Method
N=100; n=1:N;
S_vec1 = cumsum((-1).^(n+1)./factorial(2.*n - 1));
plot(n,S_vec1)

% For-loops
n_vec = 1:100;
S_vec2 = zeros(1,length(n_vec));
for ind = 1:length(n_vec)
    n = n_vec(ind);
    f_n = (-1)^(n+1)/(factorial(2*n-1)) ;
    S_vec2(ind) = f_n;
end
plot(n_vec, S_vec2,'linewidth',1.5)

% While-loops
S_vec3=[]; S = 0;
while n<=N  
    S = S + ((-1)^(n+1)/factorial(2*n-1));
    S_vec3 = [S_vec3 S];
    n = n+1;
end
n_vec = 1:N;
plot(n_vec, S_vec3,'b')
xlabel('n'); ylabel('S')

