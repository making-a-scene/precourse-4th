package bridge.ui;

import bridge.domain.Validation;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        String response = Console.readLine();
        return Validation.validateBridgeSize(response);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String response = Console.readLine();
        Validation.validateSpace(response);
        return response;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String response = Console.readLine();
        Validation.validateResponseAfterFailure(response);
        return response;
    }
}