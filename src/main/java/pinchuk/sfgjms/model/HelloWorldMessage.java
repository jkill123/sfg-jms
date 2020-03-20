package pinchuk.sfgjms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Pinchuk Yevhen
 * @created 20/03/2020 - 15:04
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HelloWorldMessage implements Serializable {

    private final long serialVersionUID = -13968921228332006L;

    private UUID id;
    private String message;
}
