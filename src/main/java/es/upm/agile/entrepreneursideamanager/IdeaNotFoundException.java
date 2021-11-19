package es.upm.agile.entrepreneursideamanager;

public class IdeaNotFoundException extends RuntimeException {

  public IdeaNotFoundException(Long id) {
    super(String.format("Could not find idea #%s", id));
  }
}
