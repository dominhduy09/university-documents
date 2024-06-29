function time_hit_ground = objhitground (initial_height , initial_velocity)
  time_hit_ground = (-initial_velocity - sqrt(initial_velocity^2 - 2 * (-9.8) * initial_height)) / (-9.8);
endfunction
