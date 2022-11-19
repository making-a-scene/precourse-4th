package bridge.domain;

import static bridge.domain.Space.*;

public class Validation {
    private static final int SIZE_FLOOR = 3;
    private static final int SIZE_CEILING = 20;
    private static final String RETRY = "R";
    private static final String QUIT = "Q";
    private static final String NOT_NUMBER_FORMAT = "다리의 길이는 정수로 입력되어야 합니다.";
    private static final String SIZE_OUT_OF_BOUNDS = "다리의 길이는 3 이상 20 이하여야 합니다.";
    private static final String NOT_U_OR_D = "U(위 칸)와 D(아래 칸) 중 하나의 문자만 선택하여 입력해야 합니다.";
    private static final String NOT_R_OR_Q = "R(재시도)와 Q(종료) 중 하나의 문자만 선택하여 입력해야 합니다.";

    public static int validateBridgeSize(String size) throws IllegalArgumentException {
        int converted = validateFormatOfSize(size);
        validateRangeOfSize(converted);
        return converted;
    }

    private static int validateFormatOfSize(String size) {
        try {
            return Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_FORMAT);
        }
    }

    private static void validateRangeOfSize(int size) {
        if (size < SIZE_FLOOR || size > SIZE_CEILING) {
            throw new IllegalArgumentException(SIZE_OUT_OF_BOUNDS);
        }
    }

    public static void validateSpace(String space) throws IllegalArgumentException {
        if (!space.equals(UP.getRepresented()) && !space.equals(DOWN.getRepresented())) {
            throw new IllegalArgumentException(NOT_U_OR_D);
        }
    }

    public static void validateResponseAfterFailure(String response) throws IllegalArgumentException {
        if (!response.equals(RETRY) && !response.equals(QUIT)) {
            throw new IllegalArgumentException(NOT_R_OR_Q);
        }
    }

}