% Example of Matrix Operations
mass = [2 4 5 10 20 50];
force = [12.5 23.2 30 61 116 294];
mu = force ./ ( 9.81 * mass)
mu_ave = mean(mu)

% Example of Matrix Operations: Evaluation of Function
z = [1:2:15]
y = (z.^3 + 5*z) ./ (4*z.^2 - 10)
