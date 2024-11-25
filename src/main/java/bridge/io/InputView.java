package bridge.io;

import bridge.domain.Move;
import bridge.domain.RestartCommand;
import bridge.io.reader.Reader;
import bridge.io.writer.Writer;

public class InputView {
    
    private final Reader reader;
    private final Writer writer;
    
    public InputView(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }
    
    public int readBridgeSize() {
        writer.write("\n다리의 길이를 입력해주세요.\n");
        return Integer.parseInt(reader.readLine());
    }

    public Move readMoving() {
        writer.write("\n이동할 칸을 선택해주세요. (위: U, 아래: D)\n");
        return Move.from(reader.readLine());
    }

    public RestartCommand readGameCommand() {
        writer.write("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\n");
        return RestartCommand.from(reader.readLine());
    }
}
