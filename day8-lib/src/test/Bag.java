package test;

import lombok.*;

@ToString
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Bag {

    @NonNull
    private String name;
    private String description;
    private double price;
}
